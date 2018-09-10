from flask import Flask, jsonify, request
import time
import walacount

app = Flask(__name__)

@app.route('/')
def index():
    type = request.args.get('type')
    if (type == 'leave'):
        if (walacount.PeopleCounter() != 0):
            d = dict()
            d['status'] = 1
            return jsonify(d)
    else:
        d = dict()
        d['status'] = 0
        return jsonify(d)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
