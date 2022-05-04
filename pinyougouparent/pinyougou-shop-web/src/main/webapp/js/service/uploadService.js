/*
app.service("uploadService",function ($http) {//构建前端服务层

    this.upload=function () {
        var formData=new FormData();//表单数据对象
        formData.append("imgFile",file.files[0]);
        return $http({
            url:"../upload.do",
            method:"POST",
            data: formData,
            headers:{"Content-Type":undefined},
            transformRequest: angular.identity  //表单序列化
        });
    }

})*/
//文件上传服务层
app.service("uploadService",function($http){ //构建前端服务层
    this.uploadFile=function(){
        var formData=new FormData(); //表单数据对象
        formData.append("file",file.files[0]);
        return $http({
            method:'POST',
            url:"../upload.do",
            data: formData,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity //表单序列化
        });
    }
});
