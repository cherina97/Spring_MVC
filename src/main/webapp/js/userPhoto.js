$("#photo").change(function (){
    let formData = new FormData();
    let photo = $('#photo')[0].files[0];

    if(photo === undefined){
        return;
    }

    formData.append('userPhoto', photo);
    $.ajax({
        url: '/Conference/user-photo/upload',
        type: 'post',
        data: formData,
        contentType: false,
        processData: false,
        success: function (userPhotoId) {
            $("#userPhoto")
                .attr("src", "/Conference/user-photo/download/" + userPhotoId);
            $("#photo-id").val(userPhotoId)
        },
    });
});