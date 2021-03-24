/*
 * Copyright 2021 BusyMachines
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package phms

trait SproutUUID extends Sprout[java.util.UUID] {

  def fromString[F[_]](s: String)(implicit F: ApplicativeThrow[F]): F[Type] =
    F.catchNonFatal(this.newType(java.util.UUID.fromString(s)))

  def generate[F[_]](implicit F: Applicative[F], random: Random[F]): F[Type] =
    random.nextBytes(16).map(b => this.newType(java.util.UUID.nameUUIDFromBytes(b)))
}

trait SproutSubUUID extends SproutSub[java.util.UUID] {

  def generate[F[_]](implicit F: Applicative[F], random: Random[F]): F[Type] =
    random.nextBytes(16).map(b => this.newType(java.util.UUID.nameUUIDFromBytes(b)))
}
