package io.scalajs.npm.winston
package transports

import io.scalajs.nodejs.process
import io.scalajs.npm.winston
import io.scalajs.npm.winston.ConfigurationOptions
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * WinstonDailyRotateFile Test Suite
  * @author lawrence.daniels@gmail.com
  */
class WinstonDailyRotateFileTest extends FunSpec {

  describe("WinstonDailyRotateFile") {

    it("supports log rotation") {
      WinstonDailyRotateFile
      val transport = new winston.transports.DailyRotateFile(new DailyRotateFileOptions(
        filename = "./src/test/resources/rotating.log",
        datePattern = "yyyy-MM-dd.",
        prepend = true,
        level = if (process.env.get("ENV").contains("development")) "debug" else "info"
      ))

      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(transport)
      ))

      logger.info("Hello World!")
    }

  }

}
