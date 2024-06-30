FROM eclipse-temurin:17

# define workdir
ARG WORKDIR=/workspace

# required for apt-get, etc.
ENV DEBIAN_FRONTEND=noninteractive

# base packages
RUN apt-get update
RUN apt-get install git-all unzip -y

# https://gist.github.com/LuanComputacao/6cf199fc577f7ee5fb85a504176d78ca
# define maven version
ARG MAVEN_VERSION=3.9.8
ARG MAVEN_BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG /root/.m2

# install maven
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${MAVEN_BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# install gradle
ARG GRADLE_VERSION=8.8
RUN \
  cd /usr/local && \
  # curl -L https://services.gradle.org/distributions/gradle-2.5-bin.zip -o gradle-2.5-bin.zip && \
  curl -L https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle-${GRADLE_VERSION}-bin.zip && \
  unzip gradle-${GRADLE_VERSION}-bin.zip && \
  rm gradle-${GRADLE_VERSION}-bin.zip

# Export some environment variables
ENV GRADLE_HOME=/usr/local/gradle-${GRADLE_VERSION}
ENV PATH=$PATH:$GRADLE_HOME/bin
#ENV PATH=$PATH:$GRADLE_HOME/bin JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

# clean up apt caches
RUN rm -rf /var/cache/apt/archives /var/lib/apt/lists/*

# switch to workdir
WORKDIR ${WORKDIR}

CMD ["/bin/bash"]