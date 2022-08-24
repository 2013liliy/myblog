$(() => {
  $("#password, #repeat_password").on("keyup", function () {
    if ($("#password").val() == $("#repeat_password").val()) {
      $("#message").css('color', 'green');
      $("#submit").attr('disabled', false);
    } else {
      $("#message").css('color', 'red');
      $("#submit").attr('disabled', true);
    }
  })
});