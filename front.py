import requests
import plotly.express as px
import pandas as pd

# Definir la URL base de tu API
BASE_URL = "http://localhost:8080/api/ventas"

# Función para obtener el total de ventas por categoría
def obtener_ventas_por_categoria():
    response = requests.get(f"{BASE_URL}/por-categoria")
    return response.json() if response.status_code == 200 else []

# Función para obtener ventas por mes
def obtener_ventas_por_mes():
    response = requests.get(f"{BASE_URL}/por-mes")
    return response.json() if response.status_code == 200 else []

# Función para obtener ventas por año
def obtener_ventas_por_anio():
    response = requests.get(f"{BASE_URL}/por-anio")
    return response.json() if response.status_code == 200 else []

# Función para obtener el top 5 clientes
def obtener_top_clientes():
    response = requests.get(f"{BASE_URL}/top-clientes")
    return response.json() if response.status_code == 200 else []

# Función para obtener ventas por método de pago
def obtener_ventas_por_metodo_pago():
    response = requests.get(f"{BASE_URL}/por-metodo-pago")
    return response.json() if response.status_code == 200 else []

# Función para graficar ventas por categoría
def graficar_ventas_por_categoria():
    data = obtener_ventas_por_categoria()
    if data:
        df = pd.DataFrame(data)
        fig = px.bar(df, x='categoria', y='totalVentas', title='Ventas por Categoría')
        fig.show()

# Función para graficar ventas por mes
def graficar_ventas_por_mes():
    data = obtener_ventas_por_mes()
    if data:
        df = pd.DataFrame(data)
        fig = px.line(df, x='mes', y='totalVentas', title='Ventas Mensuales')
        fig.show()

# Función para graficar ventas por año
def graficar_ventas_por_anio():
    data = obtener_ventas_por_anio()
    if data:
        df = pd.DataFrame(data)
        fig = px.line(df, x='anio', y='totalVentas', title='Ventas Anuales')
        fig.show()

# Función para graficar el top 5 clientes
def graficar_top_clientes():
    data = obtener_top_clientes()
    if data:
        df = pd.DataFrame(data)
        fig = px.bar(df, x='cliente', y='totalVentas', title='Top 5 Clientes con Más Ventas')
        fig.show()

# Función para graficar ventas por método de pago
def graficar_ventas_por_metodo_pago():
    data = obtener_ventas_por_metodo_pago()
    if data:
        df = pd.DataFrame(data)
        fig = px.pie(df, names='metodoPago', values='totalVentas', title='Ventas por Método de Pago')
        fig.show()

# Llamadas a las funciones para graficar los datos
if __name__ == "__main__":
    graficar_ventas_por_categoria()
    graficar_ventas_por_mes()
    graficar_ventas_por_anio()
    graficar_top_clientes()
    graficar_ventas_por_metodo_pago()
