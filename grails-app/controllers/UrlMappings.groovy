class UrlMappings {

    static mappings = {
        "/login"(controller: 'auth', action: 'index')
        "/status"(controller: 'status', action: 'index')
        "/updateStatus"(controller: 'status', action: 'updateStatus')
        "/person/index"(controller: 'person', action: 'index')
        "/functionalTests/index"(controller: 'functionalTests', action: 'index')
        "/person/show/${id}"(controller: 'person', action: 'show')
        "/unfollow/$userToUnfollow"(controller: 'person', action: 'unfollow')
        "/follow/$userToFollow"(controller: 'person', action: 'follow')
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
