# skilli-task
# APIs
{
	"info": {
		"_postman_id": "fc25f4e1-bd78-4bb1-a60d-6b54e448361f",
		"name": "SkilliGames",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Register User",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\" : \"pramatma950@gmail.com\",\r\n    \"name\" : \"Pramatma\",\r\n    \"username\" :\"Bluevirus\",\r\n    \"password\" : \"12345\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/api/v1/register",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"register"
					]
				}
			},
			"response": []
		},
		{
			"name": "Find User by Id",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/api/v1/user/4",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"user",
						"4"
					]
				}
			},
			"response": []
		},
		{
			"name": "Find all users",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/api/v1/users",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"users"
					]
				}
			},
			"response": []
		},
		{
			"name": "Update User",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\" : \"pramatma952@gmail.com\",\r\n    \"name\" : \"Pramatma3\",\r\n    \"username\" :\"Blueviru3s\",\r\n    \"password\" : \"123456\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/api/v1/user/5",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"user",
						"5"
					]
				}
			},
			"response": []
		},
		{
			"name": "Delete User",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "localhost:8080/api/v1/deleteUsers/5",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"deleteUsers",
						"5"
					]
				}
			},
			"response": []
		},
		{
			"name": "Login",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"username\" : \"Bluevirus\",\r\n    \"password\" : \"12345\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/login",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"login"
					]
				}
			},
			"response": []
		}
	]
}