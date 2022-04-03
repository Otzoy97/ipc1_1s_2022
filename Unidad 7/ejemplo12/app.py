from flask import Flask
from client.routes.client_routes import client

app = Flask(__name__)

@app.route('/')
def index():
    return {"msg" : "This api works!"}

app.register_blueprint(client)

if __name__ == '__main__':
    app.run(debug=True)