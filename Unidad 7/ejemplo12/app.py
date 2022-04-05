from flask import Flask
from flask_cors import CORS
from client.routes.client_routes import client

app = Flask(__name__)
CORS(app)

@app.route('/')
def index():
    return {"msg" : "This api works!"}

app.register_blueprint(client)

if __name__ == '__main__':
    app.run(debug=True)