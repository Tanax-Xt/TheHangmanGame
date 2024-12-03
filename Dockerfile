FROM openjdk:17

COPY . ./

WORKDIR /src

RUN javac Main.java

ENTRYPOINT ["java","Main"]