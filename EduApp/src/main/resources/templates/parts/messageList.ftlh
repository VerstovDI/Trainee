<#include "security.ftlh">
<#import "pager.ftlh" as importedPager>

<@importedPager.pager url page />
<div class="card-columns" id="message-list">
    <#list page.content as message> <!-- my-3 - Отступ сверху-снизу на 3 единицы !-->
        <div class="card my-3" data-id="${message.id}"> <!-- data-id - у каждой карточки свой атрибут - ее id"> !-->
            <div>
                <#if message.getFileName()??>
                    <img src="/img/${message.fileName}" class="card-img-top" alt="some img here" />
                </#if>
            </div>
            <div class="m-2"> <!-- Отступ со всех сторон на 2 единицы !-->
                <span>${message.text}</span><br/>
            </div>
            <i>#${message.tag}</i>
            <!-- Это закидоны из groovy.
             Всё методы getSomething могут быть заменены на
             обращение к полю (даже если оно не существует) с именем something !-->
            <div class="card-footer text-muted container">
                <div class="row">
                    <a class="col align-self-center" href="/user-messages/${message.author.id}">
                        ${message.getAuthorName()}
                    </a>
                    <a class="col align-self-center" href="#">
                        <#if message.meLiked>
                            <i class="far fa-heart"></i>
                        <#else>
                            <i class="fas fa-heart"></i>
                        </#if>
                        ${message.likes}
                    </a>
                    <#if message.author.id == currentUserId>
                        <a class="col btn btn-primary" href="/user-messages/${message.author.id}?message=${message.id}">
                            Edit
                        </a>
                    </#if>
                </div>
            </div>
        </div>
    </#list>
</div>
</@importedPager.pager url page />