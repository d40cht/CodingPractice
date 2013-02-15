#java -Xmx6800M -XX:MaxPermSize=256M -XX:+AggressiveOpts -XX:+DoEscapeAnalysis -XX:+UseCompressedOops -server -jar `dirname $0`/sbt-launch.jar "$@"
java -Xmx6800M -XX:MaxPermSize=256M -XX:+AggressiveOpts -XX:+DoEscapeAnalysis -XX:+UseCompressedOops -server -jar `dirname $0`/sbt-launch.jar "$@"
