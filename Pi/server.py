from flask import Flask, jsonify, request
import time
# modified walabot person counter code in walacount
import walacount

app = Flask(__name__)

@app.route('/')
def index():
    type = request.args.get('type')
    # 'leave' is code for leave the door skill
    if (type == 'leave'):
        if (walacount.PeopleCounter() != 0):
            d = dict()
            # status 1 means alarm needs to be stopped
            d['status'] = 1
            return jsonify(d)
    # other skill like push up counter and breathing are yet to be implemented due to compatibility issues
    else:
        d = dict()
        d['status'] = 0
        return jsonify(d)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
