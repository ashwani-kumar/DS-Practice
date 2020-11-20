import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
class ImageCache {
    fun get(fileName: String): File? {
        //Check cache dir for given file name
        var filePath = checkForFile(fileName)
        return if(!filePath.isNullOrEmpty()) {
            readFile(filePath)
        } else {
            null
        }
    }

    private fun readFile(filePath: String): File? {
        GlobalScope.launch {
            //Read file from storage
            //File(filePath)
        }
        return null
    }

    private fun checkForFile(fileName: String): String {
        return ""
    }

    fun put(file: File, fileName: String){
        writeFile(file, fileName)
    }

    private fun writeFile(file: File, fileName: String) {

    }

    fun deleteFile(fileName: String) {

    }
}