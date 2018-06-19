echo "Launching $BUILD_NAME IN K8s"
docker run -v ${TRAVIS_BUILD_DIR}/kubernetes:/kube smesch/kubectl kubectl --kubeconfig /kube/kubeconfig apply -f kube/bootstrap.yaml --validate=false
docker run -v ${TRAVIS_BUILD_DIR}/kubernetes:/kube smesch/kubectl kubectl --kubeconfig /kube/kubeconfig apply -f kube/common --validate=false --namespace=motoguard 
