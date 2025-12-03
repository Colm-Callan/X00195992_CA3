async function callApi(op) {
  const a = document.getElementById('a').value;
  const b = document.getElementById('b').value;
  const resultEl = document.getElementById('result');

  if (a === '' || b === '') {
    resultEl.textContent = 'Please enter both numbers';
    return;
  }

  try {
    const url = `/${op}?a=${encodeURIComponent(a)}&b=${encodeURIComponent(b)}`;
    const res = await fetch(url);
    if (!res.ok) {
      const text = await res.text();
      resultEl.textContent = `Error: ${res.status} ${text}`;
      return;
    }
    const text = await res.text();
    resultEl.textContent = `Result: ${text}`;
  } catch (err) {
    resultEl.textContent = `Network error: ${err.message}`;
  }
}