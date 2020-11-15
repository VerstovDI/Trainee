<#include "security.ftlh">

<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username:</label>
            <div class="col-sm-6">
                <input type="text" name="username"
                       class="form-control ${(usernameError??)?string('is-invalid','')}"
                       value="<#if user??>${user.username}</#if>"
                       placeholder="Username"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="text" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid','')}"
                       placeholder="Password" />
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <div>
            <div class="g-recaptcha" data-sitekey="6LdLM-IZAAAAAPfGx4KylRCKQZ14iT5X9cP9BYH5"></div>
            <#if captchaError??>
                <div class="alert alert-danger" role="alert">
                    ${captchaError}
                </div>
            </#if>
        </div>

        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-6">
                    <input type="text" name="password2"
                           class="form-control ${(password2Error??)?string('is-invalid','')}"
                           placeholder="Retype password" />
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">E-mail:</label>
                <div class="col-sm-6">
                    <input type="email"
                           name="email"
                           class="form-control ${(emailError??)?string('is-invalid','')}"
                           value="<#if user??>${user.email}</#if>"
                           placeholder="yourmail@some.com" />
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <br>
        <#if !isRegisterForm>
            <div>
                <a class="btn btn-primary mb-3"
                        type="submit"
                        href="/registration">
                    Sign Up
                </a>
            </div>
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
            <button class="btn btn-primary" type="submit">
                <#if user??>
                    Sign Out
                <#else>
                    Sign in
                </#if>
            </button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>
