package io.kinoplan.utils.zio.reactivemongo.driver

import scala.concurrent.duration.DurationInt

import reactivemongo.api.AsyncDriver
import zio.{TaskLayer, ZIO, ZLayer}

private[reactivemongo] object AsyncDriverResource {
  private def acquire = ZIO.attempt(AsyncDriver())

  private def release(asyncDriver: AsyncDriver) = ZIO
    .fromFuture(implicit ec => asyncDriver.close(10.seconds))
    .orDie
    .unit

  val live: TaskLayer[AsyncDriver] = ZLayer.scoped(ZIO.acquireRelease(acquire)(release))
}