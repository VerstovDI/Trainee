<#import "parts/common.ftlh" as c>

<@c.page>
    <div><h1>Hello from main page!</h1></div><!--</div>-->
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}"placeholder="Search by tag">
                <button type="submit" class="btn btn-primary ml-1">Find</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new message
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control <#if (errorsMap['textError'])??>is-invalid</#if>"
                           value="<#if message??>${message.text}</#if>"
                           name="text"
                           placeholder="Enter message here"/>
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control <#if (errorsMap['textError'])??>is-invalid</#if>"
                           value="<#if message??>${message.tag}</#if>"
                           name="tag"
                           placeholder="Tag"/>
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${tagError}
                        </div>
                    </#if>
                </div>
                <div class="custom-file">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                    <input type="file" class="form-control" name="file" id="customFile"/>
                </div>
                <input type="hidden" class="form-control" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary mt-3">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#list messages as message> <!-- my-3 - Отступ сверху-снизу на 3 единицы !-->
            <div class="card my-3"> <!-- style="width: 18rem;"> !-->
                <div>
                    <#if message.getFileName()??>
                        <img src="/img/${message.fileName}" class="card-img-top" alt="some img here"/>
                    </#if>
                </div>
                <div class="m-2"> <!-- Отступ со всех сторон на 2 единицы !-->
                    <span>${message.text}</span>
                </div>
                <i>${message.tag}</i>
                <!-- Это закидоны из groovy.
                 Всё методы getSomething могут быть заменены на
                 обращение к полю (даже если оно не существует) с именем something !-->
                <div class="card-footer text-muted">
                    <strong>${message.getAuthorName()}</strong>
                </div>
            </div>
        </#list>
    </div>
</@c.page>
