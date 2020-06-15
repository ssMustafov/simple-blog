function initEditorInEditMode(selector) {
    ClassicEditor
        .create(document.querySelector(selector))
        .catch(error => {
            console.error(error);
        });
}

function initEditorInPreviewMode(selector, content) {
    ClassicEditor
        .create(document.querySelector(selector), {
            toolbar: []
        })
        .then(editor => {
            editor.isReadOnly = true;
            editor.setData(content);
        })
        .catch(error => {
            console.error(error);
        });
}