var DataTables=function () {
    var handlerInitDataTable=function (url,columns) {
        var grid = new Datatable();
        grid.init({
            src: $("#dataTable"),
            resetGroupActionInputOnSuccess: false,
            /**
             * 数据装载成功后的回调
             * @param grid DataTable
             * @param response 服务器返回的 JSON 数据
             */
            onSuccess: function (grid, response) {
            },

            /**
             * 请求失败的回调
             * @param grid
             */
            onError: function (grid) {
                // execute some code on network or other general error
            },

            /**
             * 装载完 Ajax 数据之后的回调
             * @param grid
             */
            onDataLoad: function(grid) {
                SweetAlerts.initSweetAlert();

            },
            loadingMessage: '加载中...',
            dataTable: {
                "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable
                // 是否开启本地分页
                "paging": true,
                // 是否开启本地排序
                "ordering": false,
                // 是否显示左下角信息
                "info": true,
                // 是否允许用户改变表格每页显示的记录数
                "lengthChange": false,
                // 是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
                "processing": true,
                // 是否允许 DataTables 开启本地搜索
                "searching": false,
                // 是否开启服务器模式
                "serverSide": true,
                // 控制 DataTables 的延迟渲染，可以提高初始化的速度
                "deferRender": true,
                "autoWidth": false,
                // 增加或修改通过 Ajax 提交到服务端的请求数据

                "ajax": {
                    "url": url,
                    "type":"POST"
                },
                // 分页按钮显示选项
                "pagingType": "full_numbers",
                // 设置列的数据源
                "columns": columns,
                // 国际化
                "language": {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                buttons: []
            }
        });
        return grid;
            };
    return {
        initDataTable: function (url, columns) {
            return handlerInitDataTable(url, columns);
        }
    };
}();