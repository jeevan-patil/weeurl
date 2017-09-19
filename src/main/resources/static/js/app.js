$(function () {

  $('#shorten').click(function () {
    shorten();
  });

  function shorten() {
    clearMessage();
    var url = $("#url").val();
    if (!url) {
      failure("Please enter valid URL");
      return;
    }

    $.ajax({
      type: 'GET',
      url: '/api/v1/url/shorten?url=' + url,
      error: function () {
        failure("Something went wrong.");
      },
      success: function (data) {
        success(data);
      }
    });
  }

  function clearMessage() {
    $("#message").html("");
  }

  function success(msg) {
    var htmlContent = "<div class=\"alert alert-success\" role=\"alert\">\n"
        + "<strong>Great! Here is the shortened URL - </strong> "
        + "<a href=" + msg + " target='_blank' >" + msg + "</a>\n"
        + "        </div>";
    $("#message").html(htmlContent);
  }

  function failure(msg) {
    var htmlContent = "<div class=\"alert alert-danger\" role=\"alert\">\n"
        + msg + "\n"
        + "</div>";
    $("#message").html(htmlContent);
  }

})