package xyz.lamergameryt.allen4j

class NameSearchRequest private constructor(name: String, page: Int) {
    companion object {
        @JvmStatic
        fun build(name: String, page: Int): NameSearchRequest {
            return NameSearchRequest(name, page)
        }
    }

    val endpoint = APIEndpoint.SEARCH
    val params = HashMap<String, String>()

    init {
        params["mode"] = "0000000000";
        params["pageNumber"] = page.toString()
        params["q"] = name
    }
}