<#macro pager url page>
    <div class="mt-3">
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Pages</a>
            </li>
            <#list 1..page.getTotalPages() as listPage>
                <#if (listPage == (page.getNumber()))>
                <li class="page-item active">
                    <a class="page-link" href="#" tabindex="-1">${listPage}</a>
                </li>
                <#else>
                <li class="page-item">
                    <a class="page-link" href="${url}?page=${listPage}&size=${page.getSize()}" tabindex="-1">${listPage}</a>
                </li>
                </#if>
            </#list>
        </ul>

        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Elements of page</a>
            </li>
            <#list [5, 10, 25, 50] as c>
                <#if (c == (page.getSize()))>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${c}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</#macro>