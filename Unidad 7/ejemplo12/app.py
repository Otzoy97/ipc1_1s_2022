from flask import Flask
from flask_cors import CORS
from client.routes.client_routes import client
from account.routes.account_routes import account

app = Flask(__name__)
CORS(app)

@app.route('/')
def index():
    return {"msg" : "This api works!"}

app.register_blueprint(client)
app.register_blueprint(account)

if __name__ == '__main__':
    app.run(debug=True)