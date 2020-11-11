<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User name :</label>
            <div class="col-sm-6">
                <input type="text" name="username"
                       value="<#if user??>user.username</#if>"
                       class="form-control <#if (errorsMap['usernameError'])??>is-invalid</#if>"
                       placeholder="Username"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password :</label>
            <div class="col-sm-6">
                <input type="text" name="password"
                       class="form-control <#if (errorsMap['passwordError'])??>is-invalid</#if>"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>

        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password :</label>
                <div class="col-sm-6">
                    <input type="text" name="password2"
                           class="form-control <#if (errorsMap['password2Error'])??>is-invalid</#if>"
                           placeholder="Retype password"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email :</label>
                <div class="col-sm-6">
                    <input type="email"
                           name="email"
                           value="<#if user??>user.email</#if>"
                           class="form-control <#if (errorsMap['emailError'])??>is-invalid</#if>"
                           placeholder="yourmail@some.com"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
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
