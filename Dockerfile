FROM openjdk:17

COPY src /src
COPY src/game/words.txt /src/src/game/

WORKDIR /src

RUN javac Main.java

ENTRYPOINT ["java", "Main"]