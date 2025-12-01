// services/sendgrid.js
import sgMail from '@sendgrid/mail';

sgMail.setApiKey(process.env.SENDGRID_API_KEY);

export async function sendReportEmail({ to, subject, text, html, attachments }) {
  const msg = {
    to,
    from: process.env.REPORT_FROM_EMAIL,
    subject,
    text,
    html,
    attachments,
  };

  await sgMail.send(msg);
}
