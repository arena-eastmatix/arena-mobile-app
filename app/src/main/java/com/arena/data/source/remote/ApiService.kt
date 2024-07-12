import com.arena.data.model.BasicResponse
import com.arena.data.model.LoginRequest
import com.arena.data.model.RegisterRequest
import com.arena.data.model.TokenResponse
import com.arena.data.model.UserApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("users/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<TokenResponse>

    @POST("users/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<BasicResponse>

    @GET("users/get-current-user")
    suspend fun getCurrentUser(@Header("Authorization") token: String): Response<UserApiResponse>

    @GET("users/logout")
    suspend fun logoutUser(@Header("Authorization") token: String): Response<BasicResponse>
}
