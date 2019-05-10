var zhuti = window.localStorage.getItem("zhuti");
if(!(zhuti!=null && zhuti!="")){
	zhuti="default";
}
var yuyan=window.localStorage.getItem("yuyan");
if(!(yuyan!=null && yuyan!="")){
	yuyan="easyui-lang-zh_CN.js";
}
var quanju = {
	
}
document.write('<link rel="stylesheet" type="text/css" href="/crm_xiangmu/js/jquery-easyui-1.4.3/themes/icon.css" />');
document.write('<link rel="stylesheet" type="text/css" href="/crm_xiangmu/js/jquery-easyui-1.4.3/themes/'+zhuti+'/easyui.css" />');
document.write('<script src="/crm_xiangmu/js/jquery-easyui-1.4.3/jquery.min.js" type="text/javascript" charset="utf-8"></script>');
document.write('<script src="/crm_xiangmu/js/jquery-easyui-1.4.3/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>');
document.write('<script src="/crm_xiangmu/js/jquery-easyui-1.4.3/locale/'+yuyan+'" type="text/javascript" charset="utf-8"></script>');
document.write('<script src="/crm_xiangmu/js/yanzheng.js" type="text/javascript" charset="utf-8"></script>');