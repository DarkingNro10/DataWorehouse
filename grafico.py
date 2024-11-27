import dash
import dash_core_components as dcc
import dash_html_components as html
from dash.dependencies import Input, Output
import requests
import plotly.express as px

# Inicializar la aplicación Dash
app = dash.Dash(__name__)

# URLs de las APIs
url_categoria = "http://localhost:8081/api/ventas/por-categoria/filtrado"
url_top_clientes = "http://localhost:8081/api/ventas/top-clientes/filtrado"
url_metodo_pago = "http://localhost:8081/api/ventas/por-metodo-pago/filtrado"

# Layout de la aplicación Dash
app.layout = html.Div([
    html.H1("Dashboard de Ventas", style={'text-align': 'center'}),

    html.Div([
        # Filtros para seleccionar el mes y el año
        html.Div([
            html.Label("Seleccionar Mes(es):"),
            dcc.Checklist(
                id="meses",
                options=[{"label": f"{i}", "value": str(i)} for i in range(1, 13)],
                value=["1", "2", "3"],  # Por defecto seleccionados los 3 primeros meses
                inline=True
            ),
        ], style={'margin-bottom': '20px'}),

        html.Div([
            html.Label("Seleccionar Año(s):"),
            dcc.Checklist(
                id="años",
                options=[
                    {"label": "2021", "value": "2021"},
                    {"label": "2022", "value": "2022"},
                    {"label": "2023", "value": "2023"},
                    {"label": "2024", "value": "2024"},
                ],
                value=["2023"],  # Por defecto seleccionado 2023
                inline=True
            ),
        ], style={'margin-bottom': '20px'}),

    ]),

    # Gráficos
    html.Div([
        html.Div([
            html.H3("Ventas por Categoría"),
            dcc.Graph(id="ventas-categoria")
        ], style={'width': '33%', 'display': 'inline-block'}),

        html.Div([
            html.H3("Top 5 Clientes con Más Ventas"),
            dcc.Graph(id="top-clientes")
        ], style={'width': '33%', 'display': 'inline-block'}),

        html.Div([
            html.H3("Ventas por Método de Pago"),
            dcc.Graph(id="ventas-metodo-pago")
        ], style={'width': '33%', 'display': 'inline-block'}),

    ], style={'display': 'flex', 'justify-content': 'space-between'}),

])


# Funciones para obtener los datos desde las APIs
def obtener_datos_categoria(meses, años):
    params = {"mes": ",".join(meses), "año": ",".join(años)}
    response = requests.get(url_categoria, params=params)
    return response.json()


def obtener_top_clientes(meses, años):
    params = {"mes": ",".join(meses), "año": ",".join(años)}
    response = requests.get(url_top_clientes, params=params)
    return response.json()


def obtener_ventas_metodo_pago(meses, años):
    params = {"mes": ",".join(meses), "año": ",".join(años)}
    response = requests.get(url_metodo_pago, params=params)
    return response.json()


# Callback para actualizar los gráficos al seleccionar mes y año
@app.callback(
    [Output("ventas-categoria", "figure"),
     Output("top-clientes", "figure"),
     Output("ventas-metodo-pago", "figure")],
    [Input("meses", "value"),
     Input("años", "value")]
)
def actualizar_graficos(meses, años):
    # Obtener los datos filtrados desde las APIs
    ventas_categoria = obtener_datos_categoria(meses, años)
    top_clientes = obtener_top_clientes(meses, años)
    ventas_metodo_pago = obtener_ventas_metodo_pago(meses, años)

    # Gráfico de ventas por categoría
    categorias = [item['categoria'] for item in ventas_categoria]
    total_ventas_categoria = [item['totalVentas'] for item in ventas_categoria]
    grafico_categoria = px.bar(x=categorias, y=total_ventas_categoria, labels={'x': 'Categoría', 'y': 'Total Ventas'}, title="Ventas por Categoría")

    # Gráfico de top 5 clientes
    clientes = [item['cliente'] for item in top_clientes]
    total_ventas_clientes = [item['totalVentas'] for item in top_clientes]
    grafico_top_clientes = px.bar(x=clientes, y=total_ventas_clientes, labels={'x': 'Cliente', 'y': 'Total Ventas'}, title="Top 5 Clientes con Más Ventas")

    # Gráfico de ventas por método de pago
    metodo_pago = [item['metodoPago'] for item in ventas_metodo_pago]
    total_ventas_metodo_pago = [item['totalVentas'] for item in ventas_metodo_pago]
    grafico_metodo_pago = px.pie(names=metodo_pago, values=total_ventas_metodo_pago, title="Ventas por Método de Pago")

    return grafico_categoria, grafico_top_clientes, grafico_metodo_pago


if __name__ == '__main__':
    app.run_server(debug=True, port=8050)
