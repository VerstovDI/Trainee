<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User name :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Username"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password :</label>
            <div class="col-sm-6">
                <input type="text" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>

        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email :</label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="yourmail@some.com"/>
                </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <br>
        <#if !isRegisterForm>
            <a href="/registration">Sign up</a>
        </#if>
        <div>
            <button class="btn btn-primary" type="submit">
                <#if isRegisterForm>
                    Sign Up
                <#else>
                    Sign In
                </#if>
            </button>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <div>
            <button class="btn btn-primary" type="submit">Sign Out</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>
