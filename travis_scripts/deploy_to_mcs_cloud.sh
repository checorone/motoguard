echo "Launching $BUILD_NAME IN K8s"
docker run -v ${TRAVIS_BUILD_DIR}/kubernetes:/kube smesch/kubectl kubectl --kubeconfig /kube/kubeconfig delete ns motoguard
docker run -v ${TRAVIS_BUILD_DIR}/kubernetes:/kube smesch/kubectl kubectl --kubeconfig /kube/kubeconfig create ns motoguard
docker run -v ${TRAVIS_BUILD_DIR}/kubernetes:/kube smesch/kubectl kubectl --kubeconfig /kube/kubeconfig apply -f kube --namespace=motoguard
