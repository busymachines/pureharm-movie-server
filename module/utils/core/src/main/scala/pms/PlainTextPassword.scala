package pms

/** @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 20 Jun 2018
  */
@scala.deprecated("Use the one from pms.kernel.", "2021.03.21")
object PlainTextPassword {

  //TODO: make these restrictions configurable
  def apply(pw: String): Attempt[PlainTextPassword] =
    if (pw.length < 6)
      Fail.invalid("Password needs to have at least 6 characters").raiseError[Attempt, PlainTextPassword]
    else new PlainTextPassword(pw).pure[Attempt]

}
@scala.deprecated("Use the one from pms.kernel.", "2021.03.21")
final class PlainTextPassword private (val plainText: String) {

  //generated by IntelliJ
  override def equals(other: Any): Boolean = other match {
    case that: PlainTextPassword =>
      plainText == that.plainText
    case _ => false
  }

  //generated by IntelliJ
  override def hashCode(): Int =
    31 * plainText.hashCode
}
