package xyz.lamergameryt.allen4j.profile

import xyz.lamergameryt.allen4j.APIEndpoint
import xyz.lamergameryt.allen4j.Request

/**
 * The `SelfProfileRequest` class is used to perform a request that get your own profile information..
 */
class SelfProfileRequest private constructor(): Request() {
    companion object {
        /**
         * Creates an instance of this class.
         *
         * @return Instance of [SelfProfileRequest]
         */
        @JvmStatic
        fun build(): SelfProfileRequest {
            return SelfProfileRequest()
        }
    }

    /**
     * The endpoint of the [SelfProfileRequest] request.
     */
    override val endpoint = APIEndpoint.SELF_PROFILE
}