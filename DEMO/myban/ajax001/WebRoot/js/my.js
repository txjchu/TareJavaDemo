/* ��������ѡ��ȡjson���ݲ��Զ���������ѡ�ķ��� */
function addOption(selectValue, uri, id){//selectValue ����ѡ�������ѡ��ǰѡ���value��uri ��Ҫ����������·����id ׼���������ݵ�����ѡ��id.
	var xhr = getXhr();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var txt = xhr.responseText;//��ȡ����������������jsonStr
			var jsObj = txt.evalJSON();//��jsonStrת��Ϊjs����
			$(id).innerHTML = "";//��Ҫ�������ѡ��select�е�������ա�
			for(var i = 0; i < jsObj.length; i++){//����jsObj���ϻ�����
				var op = new Option(jsObj[i].name, jsObj[i].value);
				$(id).options[i] = op;//������ѡ��options�����OptionԪ�ض���
			}
		}		
	}; 
	xhr.open("post", uri, true);
	xhr.setRequestHeader("content-type",'application/x-www-form-urlencoded');//post������Ҫ������Ϣͷ��Ϣ
	xhr.send("name="+ selectValue);
}

/* ��ݻ�ȡԪ�صķ��� */
function $(id){
	return document.getElementById(id);
}
/* ��ݶ�ȡԪ��valueֵ�ķ���:����id��ȡԪ�ص�value��ֵ */
function $F(id){
	return $(id).value;
}

/* ��ȡAjax����ķ��� */
function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActionXObject("Microsoft.XMLHttp");
	}
	return xhr;
}