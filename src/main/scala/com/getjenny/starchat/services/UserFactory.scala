package com.getjenny.starchat.services

case class UserClassNotFoundException(message: String = "", cause: Throwable = None.orNull  )
  extends Exception(message, cause)

import scalaz.Scalaz._

object SupportedAuthCredentialStoreImpl extends Enumeration {
  type Permission = Value
  val es, unknown = Value
  def getValue(authMethod: String) =
    values.find(_.toString === authMethod).getOrElse(SupportedAuthCredentialStoreImpl.unknown)
}

object UserFactory {
  def apply(userCredentialStore: SupportedAuthCredentialStoreImpl.Value): AbstractUserService = {
    userCredentialStore match {
      case SupportedAuthCredentialStoreImpl.es =>
        new UserEsService
      case _ =>
        throw UserClassNotFoundException("User service credentials store not supported: " + userCredentialStore)
    }
  }
}