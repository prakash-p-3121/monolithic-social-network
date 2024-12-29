docker pull mysql:9.1
docker run --name mysql1  -e MYSQL_ROOT_PASSWORD="root" -p 3306:3306  -d mysql:9.1
