from bottle import route, run, get, put, post
import json

class Person:
	def __init__(self,name,age):
		self.name=name
		self.age=age		
	def to_json(self):
		return json.dumps(self.__dict__)

@get('/person/<id>')
def get_person(id):
	return people[id].to_json()
	
@post('/person/<id>/<name>/<age>')
def add_person(id,name,age):
	people[id]=Person(name,age)
	print people[id]
	return "ok"
	
@get('/people')
def list_people():
	return ""
	
	
people={
	"1" : Person('Orlando',25),
	"2" : Person('Lina',25)
}

run(host='0.0.0.0', port=8080, debug=True)
