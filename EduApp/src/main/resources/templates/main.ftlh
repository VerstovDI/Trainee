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

    <#include "parts/messageEdit.ftlh" />

    <#include "parts/messageList.ftlh" />

</@c.page>
