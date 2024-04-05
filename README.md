# 2024-microservices-datadog-demo

Data dog gives only 14 days trial u can use their platform and agent.
To install and send logs to DD.

Follow below :
In terminal -> DD_AGENT_MAJOR_VERSION=7 DD_API_KEY=<API_KEY> DD_SITE="datadoghq.eu" bash -c "$(curl -L https://install.datadoghq.com/scripts/install_mac_os.sh)"

RUN THIS TO DOWNLOAD AGENT AND TO RUN IT.

->UNDER .datadog-agent-> 
create datadog.yaml file if it doesnt exist - file is uploaded.

->UNDER .datadog-agent-> conf.d->java.d-> create conf.yaml file - file is uploaded.
