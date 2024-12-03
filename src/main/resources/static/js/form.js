function submitForm()
{
    console.log("submitForm() called");
    $(document).ready(function () {
        $('#myForm').submit(function (event) {
            event.preventDefault();
            let formData = $(this).serialize();
            $.ajax({
                type: "POST",
                url: "/",
                data: formData,
                success: function (data) {
                    alert("Form submitted successfully!");
                }
            });
        });
    });
}