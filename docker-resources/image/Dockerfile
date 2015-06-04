FROM dockerfile/java:oracle-java8

MAINTAINER Daniel Lavoie <dlavoie@cspinformatique.com>

ADD csp-forms.jar /csp-forms/csp-forms.jar
ADD run.sh /run.sh

RUN chmod +x /*.sh

VOLUME [/"data"]

EXPOSE 8080

CMD ["/run.sh"]