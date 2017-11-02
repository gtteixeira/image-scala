
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64
import java.text.SimpleDateFormat
import java.util.Date
import scala.language.implicitConversions
import java.io.FileOutputStream


//Part of this code was translated from a java code from:
//Parte desde código foi obtido a partir da tradução do código JAVA contido na página:
// https://www.programcreek.com/2009/02/java-convert-image-to-byte-array-convert-byte-array-to-image/


object convertImageArray extends App {

  try {


    val dirName = "your directory"

    //To convert image into byteArray. Converter imagem em byte array
    val baos = new ByteArrayOutputStream(1000)
    val img = ImageIO.read(new File(dirName,"yourFile.png"))
    ImageIO.write(img, "jpg", baos)
    baos.flush()


    val base64String = Base64.encode(baos.toByteArray())
    baos.close()



    val bytearray = Base64.decode(base64String)

    bytearray.foreach(println)


    //Rewrite image file from byteArray. Reescrevendo um arquivo de imagem a partir do bytearray.

    val imag=ImageIO.read(new ByteArrayInputStream(bytearray))


    //File Name.
    val nomeComData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'.jpg'").format(new Date())

    val dirName2 = "your output directory"

    ImageIO.write(imag, "jpg", new File(dirName2,nomeComData))

    println ("Gerado o arquivo: "  + nomeComData )
    println (" no diretório: " + dirName2)


    //Save the byteArray in a txt file. Imprime o bytearray em arquivo txt.

    val nomeComDataTXT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'.txt'").format(new Date())


    val fileoutput = new FileOutputStream(nomeComDataTXT)
    fileoutput.write(bytearray)

  } catch {

    case ex: IOException => {
      println("Erro em algum processo!")

    }
  }
}


