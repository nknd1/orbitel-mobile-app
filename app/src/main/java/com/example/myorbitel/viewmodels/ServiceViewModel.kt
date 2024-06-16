
/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myorbitel.models.AddServiceRequest
import com.example.myorbitel.models.AddServiceResponse
import com.example.myorbitel.models.Services
import com.example.myorbitel.utils.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ServiceViewModel : ViewModel() {
    private val _services = MutableLiveData<List<Services>>()
    val services: LiveData<List<Services>> get() = _services

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error


    private val _addServiceResponse = MutableLiveData<String>()
    val addServiceResponse: LiveData<String> get() = _addServiceResponse

    fun fetchServices() {
        _loading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getAllServices()
                withContext(Dispatchers.Main) {
                    _services.value = response
                    _loading.value = false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _error.value = "Error: ${e.message}"
                    _loading.value = false
                }
            }
        }
    }
    fun addServiceToTariff(serviceId: String, tariffId: Int) {
        _loading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = AddServiceRequest(service_id = serviceId, tariff_id = tariffId)
                val response: Response<AddServiceResponse> = RetrofitInstance.api.addServiceToTariff(request)

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _addServiceResponse.value = response.body()?.message ?: "Service added successfully"
                    } else {
                        _error.value = "Error: ${response.errorBody()?.string()}"
                    }
                    _loading.value = false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _error.value = "Error: ${e.message}"
                    _loading.value = false
                }
            }
        }
    }
}



 */
