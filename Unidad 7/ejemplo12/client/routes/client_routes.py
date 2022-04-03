from flask import Blueprint, Response, jsonify, request

client = Blueprint('client', __name__, url_prefix='/api/client')

@client.route('', methods=['POST'])
def create():
    body = request.get_json()
    print(body)
    return {'msg': 'cuenta de cliente creada'}, 200