WORKSPACE="/docker-workspace/csp-forms"

unzip -o $WORKSPACE/target/docker.zip -d $WORKSPACE/target

docker build -t cspinformatique/csp-forms $WORKSPACE/target/docker
