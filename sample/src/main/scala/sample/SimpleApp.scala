package sample

import scalikejdbc._

object SimpleApp extends App {
  ScalikejdbcUtils.initialize()
  implicit val session = AutoSession

  val count = sql"""select count(*) as c from baseball.batting"""
    .map(_.int("c")).first.apply().get
  println(s"count = ${count}")
}

object ScalikejdbcUtils {
  def initialize() {
    val host = System.getenv("MYSQL_SERVER_HOST")
    val port = System.getenv("MYSQL_SERVER_PORT")
    val user = System.getenv("MYSQL_SERVER_USER")
    val password = System.getenv("MYSQL_SERVER_PASSWORD")
    Class.forName("com.mysql.jdbc.Driver")
    ConnectionPool.singleton(s"jdbc:mysql://$host:$port", user, password)
  }
}
