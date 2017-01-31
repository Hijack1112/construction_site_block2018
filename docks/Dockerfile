FROM airhacks/payara-configured
MAINTAINER Adam Bien, adam-bien.com
# For more information about ping see: https://github.com/AdamBien/ping/
ADD target/docks.war ${DEPLOYMENT_DIR}
HEALTHCHECK --interval=15s CMD curl --fail http://localhost:8080/ping/resources/pings/echo/+ || exit 1
