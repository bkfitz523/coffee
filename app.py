#!flask/bin/python
from flask import Flask, jsonify
import requests 
import json
import urllib.request

app = Flask(__name__)

@app.route('/')
def index():
    return "Hello, World!"

@app.route('/api/v1.0/catalog')
def catalog(): #supplier_01
    r = requests.get('http://coffee-net.azurewebsites.net/api/catalog')
    return r.text

@app.route('/api/v1.0/catalog?id=1')
def catalog(): #supplier_01
    r = requests.get('http://coffee-net.azurewebsites.net/api/catalog')
    return r.text

@app.route('/api/v1.0/coffees')
def coffees(): #supplier_02
    p = requests.get('http://coffee-hawaii-boom.azurewebsites.net/api/v1.0/coffees')
    return p.text

# @app.route('/api/v1.0/scott')
# def scott():
#      p = urllib.request.urlopen('http://coffee-hawaii-boom.azurewebsites.net/api/v1.0/coffees').read()
#      return json.loads(p.decode())
#      for k in my_list:
#    	    if k in my_dict:
#             print k, my_dict[k]

@app.route('/api/v1.0/total')
def get_total():
    cat = catalog()
    cof = coffees()
    return cat+cof

if __name__ == '__main__':
    app.run(debug=True)

    #differences of json keys between supplier catalogs
    # catalog-coffees
    # id-id
    # description-title
    # pricingData.cost-price
    # pricingData.size-size
    # pricingData.instock-availability
    # tastingNotes-description
    # null-fair_trade
    # null-grinds["",""]
