<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <div><h1>Hello from main page!</h1></div><!--</div>-->
    <div>
        <div>
            <@l.logout />
            <span><a href="/user">User list</a></span>
        </div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="text" placeholder="Введите сообщение!"/>
            <input type="tag" name="tag" placeholder="Тэг"/>
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
        <br>
        <form method="get" action="/main">
            <input type="text" name="filter" value="${filter!}">
            <button type="submit">Найти</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <b>${message.text}</b>
            <b>${message.tag}</b>
            <!-- Это закидоны из groovy.
             Всё методы getSomething могут быть заменены на
             обращение к полю (даже если оно не существует) с именем something !-->
            <strong>${message.getAuthorName()}</strong>
            <div>
                <#if message.fileName??> <!-- ?? - приведение к Boolean -->
                    <img src="/img/${message.fileName}" alt="some img here">
                </#if>
            </div>
        </div>
        <#else>
            No message
    </#list>
</@c.page>
